package pt.caixamagica.budyfinders.activities.firebase

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import pt.caixamagica.budyfinders.activities.SignUpActivity
import pt.caixamagica.budyfinders.models.User
import pt.caixamagica.budyfinders.utils.Constants

class FirestoreClass {
    fun getCurrentUserID(): String {
        var currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserID = ""
        if(currentUser != null){
            currentUserID = currentUser.uid
        }
        return currentUserID
    }

    fun registerUser(activity: SignUpActivity, user: User) {
        mFirestore.collection(Constants.USERS)
            .document(getCurrentUserID())
            .set(user, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }
            .addOnFailureListener {
                exception ->
                Log.e(activity.javaClass.simpleName, "Fail creating",exception)
            }

    }

    private val mFirestore = FirebaseFirestore.getInstance()
}