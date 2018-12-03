package com.inducesmile.firestoreexample.repository;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.inducesmile.firestoreexample.CustomApplication;
import com.inducesmile.firestoreexample.FirestoreUserModel;
import com.inducesmile.firestoreexample.utils.Constants;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class UserImpl implements IUserRepository {

    private static final String TAG = UserImpl.class.getSimpleName();

    private Context context;

    private FirebaseFirestore db;

    private CustomApplication app;


    public UserImpl(Context context) {
        this.context = context;
        app = CustomApplication.getInstance();
    }


    @Override
    public void doesUserEmailExist(String email) {
        Task<DocumentSnapshot> docSnapshot = db.collection(Constants.USER_COLLECTION).document(email).get();
        docSnapshot.addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    // user already exist in database
                }else{
                    //user does not exist in database
                }
            }
        });
    }


    @Override
    public void addNewRegisteredUser(FirestoreUserModel firestoreUserModel) {
        Map<String, Object> user = new HashMap<>();
        user.put(Constants.DocumentFields.USERNAME, firestoreUserModel.getUsername());
        user.put(Constants.DocumentFields.EMAIL, firestoreUserModel.getEmail());
        user.put(Constants.DocumentFields.PASSWORD, firestoreUserModel.getPassword());

        Task<Void> newUser = db.collection(Constants.USER_COLLECTION).document(firestoreUserModel.getEmail()).set(user);
        newUser.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "User was successfully added");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Error has occured " + e.getMessage());
            }
        });
    }
}
