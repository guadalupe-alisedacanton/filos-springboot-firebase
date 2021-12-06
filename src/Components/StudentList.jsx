import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import { useParams } from "react-router-dom";



function StudentList() {

    const { classId } = useParams();

    // const [error, setError] = useState(null);
    // const [isLoaded, setIsLoaded] = useState(false);
    // const [items, setItems] = useState([]);

    const items = [
        { id: "1", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "2", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "3", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "4", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "5", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "6", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "7", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "8", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "9", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "10", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "11", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "12", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "1", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "2", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "3", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "4", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "5", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "6", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "7", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "8", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "9", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "10", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "11", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "12", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "1", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "2", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "3", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "4", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "5", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "6", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "7", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "8", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "9", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "10", name: "Alex Hatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "11", name: "Alex Badzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },
        { id: "12", name: "Alex Skatzo", imgURL: "https://ui.dev/images/authors/tyler.jpeg" },

    ]

    // Note: the empty deps array [] means
    // this useEffect will run once
    // similar to componentDidMount()
    // useEffect(() => {
    //     fetch("https://api.example.com/items") //className
    //         .then(res => res.json())
    //         .then(
    //             (result) => {
    //                 setIsLoaded(true);
    //                 setItems(result);
    //             },
    //             // Note: it's important to handle errors here
    //             // instead of a catch() block so that we don't swallow
    //             // exceptions from actual bugs in components.
    //             (error) => {
    //                 setIsLoaded(true);
    //                 setError(error);
    //             }
    //         )
    // }, [])

    // if (error) {
    //     return <div>Error: {error.message}</div>;
    // } else if (!isLoaded) {
    //     return <div>Loading...</div>;
    // } else {
    return (
        <section>
            <div className="row">
                {items.map(item => (
                    <div className="col-4 d-inline">
                        <Link to={"/Profile/" + item.name}>
                            <img src={item.imgURL} style={{ height: "100px", width: "100px" }} />
                            <h4>{item.name}</h4>
                        </Link>
                    </div>


                ))}


            </div >

        </section >



    );
}

// }

export default StudentList;