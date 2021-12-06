import React from 'react'
import { useParams } from "react-router-dom";
import Students from "./Students.json";

function FindElement() {
    const { name } = useParams();
    return Students.students.find(item => {
        if (item.name === name) return item;
    });
}


function Banner(props) {
    let match = FindElement();
    let guest = props.isGuest;
    if (guest === false) {
        return (
            console.log('match.id = ', match),
            <section className="container-banner">

                <h1>
                    {match.name}
                    <br />
                    Students enrolled: {match.studentCount}</h1>
                <section className="mr-2 ml-2">

                    <a href="#">
                        <button type="button" class="mb-2 btn btn-primary btn-lg btn-block">
                            <span className="icon fa fa-user-plus" style={{ color: 'white' }} >Add Class</span>
                        </button>
                    </a>
                    <a href="/Students/class" >
                        <button type="button" class="btn btn-secondary btn-lg btn-block">
                            <span className="icon fa fa-list" style={{ color: 'white' }}>View Students</span>
                        </button>
                    </a>
                    <br />

                </section>

            </section>
        )
    }
    else {
        return (
            console.log('match.id = ', match),
            <section className="container-banner">

                <h1>
                    {match.className}
                    <br />
                    Students enrolled: {match.count}</h1>
                <section className="mr-2 ml-2">
                    <a href="/Students/class" >
                        <button type="button" class="btn btn-secondary btn-lg btn-block">
                            <span className="icon fa fa-list" style={{ color: 'white' }}>View Students</span>
                        </button>
                    </a>
                    <br />

                </section>

            </section>
        )
    }
}


export default Banner


