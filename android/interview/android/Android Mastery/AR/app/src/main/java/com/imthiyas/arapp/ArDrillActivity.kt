package com.imthiyas.arapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.ar.core.ArCoreApk
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.Color
import com.google.ar.sceneform.rendering.MaterialFactory
import com.google.ar.sceneform.rendering.ShapeFactory
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode


class ArDrillActivity : AppCompatActivity() {

    private lateinit var arFragment: ArFragment
    private var placedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar_drill)


        val availability = ArCoreApk.getInstance().checkAvailability(this)
        Log.d("availability", "$availability")
        if (availability.isUnsupported) {
            Toast.makeText(this, "ARCore not supported on this device", Toast.LENGTH_LONG).show()
            finish()
            return
        }



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED
        ) {
            startArScene()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 101)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startArScene()
        }
    }

    private fun startArScene() {
        arFragment = ArFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.ar_fragment_container, arFragment)
            .commit()

        supportFragmentManager.executePendingTransactions()

        arFragment.setOnTapArPlaneListener { hitResult, _, _ ->
            if (!placedOnce) {
                val anchor = hitResult.createAnchor()
                val anchorNode = AnchorNode(anchor)
                anchorNode.setParent(arFragment.arSceneView.scene)

                MaterialFactory.makeOpaqueWithColor(this, Color(android.graphics.Color.RED))
                    .thenAccept { material ->
                        val cube = ShapeFactory.makeCube(
                            Vector3(0.1f, 0.1f, 0.1f),
                            Vector3.zero(),
                            material
                        )
                        val node = TransformableNode(arFragment.transformationSystem)
                        node.renderable = cube
                        node.setParent(anchorNode)
                        node.select()
                        placedOnce = true
                    }
            }
        }
    }
}
