package cbconnectit.portfolio.web

import dev.gitlive.firebase.externals.FirebaseApp
import dev.gitlive.firebase.externals.initializeApp
import dev.gitlive.firebase.storage.externals.*
import org.khronos.webgl.Int8Array
import org.w3c.files.Blob
import org.w3c.xhr.BLOB
import org.w3c.xhr.XMLHttpRequest
import org.w3c.xhr.XMLHttpRequestResponseType
import kotlin.js.json

object ProjectInit {
    private var app: FirebaseApp? = null
    private var storage: FirebaseStorage? = null

    fun some() {
        app = initializeApp(
            json(
                "storageBucket" to "https://www.google.be",
                "apiKey" to "AIzaSyDGfMGQTYTAq7KlGJs1tP2BGcGc_42GXA4",
                "authDomain" to "portfolio-d54c5.firebaseapp.com",
                "projectId" to "portfolio-d54c5",
                "storageBucket" to "portfolio-d54c5.appspot.com",
                "messagingSenderId" to "1087510076903",
                "appId" to "1:1087510076903:web:519baba1985aeaf6827142",
                "measurementId" to "G-0MGNK2PQFK"
            )
        )

        storage = getStorage(app)

//
//        console.log(app?.name)
//        console.log(app?.options?.storageBucket)
//        console.log("hello 2")
//        console.log("hello 3")
//        console.log(storage?.maxOperationRetryTime)
//
//        if (storage != null) {
//            val pathReference = ref(storage!!, "img_services_backend_ktor.svg")
//
//            console.log("hello 4")
//
//            console.log(pathReference)
//
//            getDownloadURL(pathReference).then {
//                val xhr = XMLHttpRequest()
//                xhr.responseType = XMLHttpRequestResponseType.BLOB
////                xhr.onload = { event ->
////                    val blob = xhr.response
////                    blob.asDynamic()
////                }
//
//                xhr.open("GET", it)
//                xhr.send()
//
//                console.log(pathReference)
//                console.log(it)
//            }
//        }
    }

    fun uploadFile(fileName: String, file: Blob) {
        if (storage == null) return

        val reference = ref(storage!!, fileName)

        console.log("fullPath: ", reference.fullPath)
        console.log("name: ", reference.name)

        uploadBytes(reference, file).then {
            console.log("Uploaded blob or file?!?!?!?!")
        }
    }
}