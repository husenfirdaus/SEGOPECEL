package com.example.segopecel2.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.segopecel2.R
import com.example.segopecel2.application.PecelApp
import com.example.segopecel2.databinding.FragmentSecondBinding
import com.example.segopecel2.model.Pecel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val PecelViewModel: PecelViewModel by viewModels {
        PecelViewModelFactory((applicationContext as PecelApp).repository)
    }
    private val args : SecondFragmentArgs by navArgs()
    private var pecel: Pecel? = null
    private lateinit var mMap: GoogleMap
    private var currentLatLang: LatLng? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val cameraRequestCode = 2

    override fun onAttach(context: Context) {
        super.onAttach(context)
        applicationContext = requireContext().applicationContext
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pecel = args.pecel
        if (pecel != null){
            binding.deletebutton.visibility = View.VISIBLE
            binding.savebutton.text = "Ubah"
            binding.NameeditTextText.setText(pecel?.name)
            binding.addresseditTextText2.setText(pecel?.address)
            binding.SidedishEditTextText3.setText(pecel?.sidedish)
            binding.drinkeditText.setText(pecel?.drink)
            binding.priceTextText2.setText(pecel?.price)
        }

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        checkPermission()

        val name = binding.NameeditTextText.text
        val address = binding.addresseditTextText2.text
        val sidedish = binding.SidedishEditTextText3.text
        val drink = binding.drinkeditText.text
        val price = binding.priceTextText2.text
        binding.savebutton.setOnClickListener {
            if (name.isEmpty()){
                Toast.makeText(context,"Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (address.isEmpty()){
                Toast.makeText(context,"Alamat tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (sidedish.isEmpty()){
                Toast.makeText(context,"Lauk tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (drink.isEmpty()){
                Toast.makeText(context,"Minuman tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (price.isEmpty()){
                Toast.makeText(context,"Harga tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else{
                if ( pecel == null) {
                    val pecel = Pecel(0, name.toString(),
                        address.toString(), sidedish.toString(), drink.toString(), price.toString(),currentLatLang?.latitude,currentLatLang?.longitude)
                    PecelViewModel.insert(pecel)
                }else{
                    val pecel = Pecel(pecel?.id!!, name.toString(),
                        address.toString(), sidedish.toString(), drink.toString(), price.toString(),currentLatLang?.latitude ,currentLatLang?.longitude)
                    PecelViewModel.updete(pecel)

                }

                findNavController().popBackStack() //untuk dismiss halaman ini
            }

        }

        binding.deletebutton.setOnClickListener {
            pecel?.let {  PecelViewModel.delete(it) }
            findNavController().popBackStack()
        }
        binding.cameraButton.setOnClickListener {
            checkCameraPermission()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val uiSettings = mMap.uiSettings
        uiSettings.isZoomControlsEnabled = true

        mMap.setOnMarkerDragListener(this)


    }

    override fun onMarkerDrag(p0: Marker) {}

    override fun onMarkerDragEnd(marker: Marker) {
        val newPosition = marker.position
        currentLatLang = LatLng(newPosition.latitude, newPosition.longitude)
        Toast.makeText(context, currentLatLang.toString(),Toast.LENGTH_SHORT).show()
    }

    override fun onMarkerDragStart(p0: Marker) {
    }

    private fun checkPermission(){
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(applicationContext)
        if (ContextCompat.checkSelfPermission(
            applicationContext,
            android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ){
            getCurrentLocation()
        }else{
            Toast.makeText(applicationContext, "Akses lokasi ditolak", Toast.LENGTH_SHORT).show()
        }
    }
    private fun getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(
                applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null){
                    var latLang = LatLng(location.latitude, location.longitude)
                    currentLatLang = latLang
                    var title = "Marker"


                    if (pecel != null){
                        title = pecel?.name.toString()
                        val newCurrentlocation = LatLng(pecel?.latitude!!, pecel?.longitude!!)
                        latLang = newCurrentlocation
                    }
                    val markerOption = MarkerOptions()
                        .position(latLang)
                        .title(title)
                        .draggable(true)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_pecel_32))
                    mMap.addMarker(markerOption)
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLang, 15f))
                }
            }
    }
    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                applicationContext,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED){
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(android.Manifest.permission.CAMERA),
                    cameraRequestCode
                )
            }
        }else{
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, cameraRequestCode)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == cameraRequestCode) {
         val photo: Bitmap = data?.extras?.get("data") as Bitmap
         binding.photoImageView.setImageBitmap(photo)
        }
    }
}