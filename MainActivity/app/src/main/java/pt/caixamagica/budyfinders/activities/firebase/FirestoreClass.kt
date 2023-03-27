package pt.caixamagica.budyfinders.activities.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreClass {
    fun getCurrentUserID(): String {
        var currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserID = ""
        if(currentUser != null){
            currentUserID = currentUser.uid
        }
        return currentUserID
    }

    private val mFirestore = FirebaseFirestore.getInstance()
}