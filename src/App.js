import './App.css';
import Header from './Components/Header';

import React, { useState } from 'react';

import firebase from 'firebase/compat/app';
import 'firebase/compat/firestore';
import 'firebase/compat/auth';

import { useAuthState } from 'react-firebase-hooks/auth';


firebase.initializeApp({
  apiKey: "AIzaSyCiKqguxaBzxj0nlvI--v2brt5gSeGGt_w",
  authDomain: "group-project-a8653.firebaseapp.com",
  databaseURL: "https://group-project-a8653-default-rtdb.firebaseio.com",
  projectId: "group-project-a8653",
  storageBucket: "group-project-a8653.appspot.com",
  messagingSenderId: "857527012368",
  appId: "1:857527012368:web:dd4292fb5f57fbc9044e95"
})

const auth = firebase.auth();
const firestore = firebase.firestore();


function App() {
  const [guest, setGuest] = useState(false);

  let [user] = useAuthState(auth);

  const [firstTime, setFirstTime] = useState(true);



  function SignIn() {
    const signInWithGoogle = () => {
      const provider = new firebase.auth.GoogleAuthProvider();
      auth.signInWithPopup(provider);

      //api call to save user name and photoURL
      // const { uid, photoURL } = auth.currentUser;

      //api call to return user given name/email,
      //if null must send him to register page
    }

    const signInAsGuest = () => {

      setGuest(true);
    }

    return (
      <div className="container">
        <button onClick={signInWithGoogle}> Sign In With Google </button>

        <button onClick={signInAsGuest}> Continue As Guest </button>
      </div>
    )
  }

  if (user) {
    return (

      <div className="App">
        <section>

          <Header guest={guest} firstTime={firstTime} name={user.displayName} />

        </section>



      </div>
    );
  } else if (guest) {
    return (
      <div className="App">
        <section>
          <Header guest={guest} />
        </section>
      </div>
    );
  } else {
    return (
      <div className="App">
        <section>
          <SignIn />
        </section>
      </div>
    );
  }


}

function SignOut() {

  return auth.currentUser && (
    <button onClick={() => auth.signOut()}> Sign Out</ button>
  )

}

export default App;
