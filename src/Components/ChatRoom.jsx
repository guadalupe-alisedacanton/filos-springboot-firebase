import React, { useRef, useState } from 'react'


import firebase from 'firebase/compat/app';
import 'firebase/compat/firestore';
import 'firebase/compat/auth';

import { useCollectionData } from 'react-firebase-hooks/firestore';

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


export default function ChatRoom(props) {
    const chatId = props.classId;
    // const [chatId, setChatId] = useState(props.classId)

    const dummy = useRef();

    const messagesRef = firestore.collection(`${chatId}`);
    const query = messagesRef.orderBy('createdAt').limit(200);

    const [messages] = useCollectionData(query, { idField: 'id' });

    const [formValue, setFormValue] = useState('');

    const sendMessage = async (e) => {
        e.preventDefault();

        const { uid, photoURL } = auth.currentUser;

        await messagesRef.add({
            text: formValue,
            createdAt: firebase.firestore.FieldValue.serverTimestamp(),
            uid,
            photoURL
        });

        setFormValue(' ');

        dummy.current.scrollIntoView({ behavior: "smooth" });
    }

    return (
        <div>

            <main>


                <div>
                    {messages && messages.map(msg => <ChatMessage key={msg.id} message={msg} />)}
                </div>

                <div ref={dummy}></div>
                <form className="chat-form " onSubmit={sendMessage}>
                    <input className="chat-input" placeholder="Meet your classmates" value={formValue} onChange={(e) => setFormValue(e.target.value)}>

                    </input>

                    <button type="submit" > Send</button>
                </form>
            </main>

            <div>

            </div>
        </div>

    )
}

function ChatMessage(props) {
    const { text, uid, photoURL } = props.message;

    const messageClass = uid === auth.currentUser.uid ? 'sent' : 'received';

    return (
        <div className={`message ${messageClass}`}>
            <img src={photoURL} />

            <p> {text} </p>

        </div>
    )
}

