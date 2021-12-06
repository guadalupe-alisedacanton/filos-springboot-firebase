import React, { Component } from 'react'
import Students from "./Students.json"; // json file that I made 
import { Link } from "react-router-dom";

class Classes extends Component{
    render() {
        let guest = this.props.isGuest;
        console.log("guest = ", guest)
        return (
            <main>
                <div className="container">
                    
                    <div className="row">
                        {Students.students.map((temp, i) => // iterates through the array, students is the array name in the json file Students.json
                        { // i is a counter 
                            if(guest === false)
                            {
                                return (
                                    <div className="col-4" style={{ padding: "10px" }}>
                                        <div className="card" >
                                            
                                            <div className="card-body">
                                                <Link to={`../Banner/${temp.name}`} >
                                                    <h5 className="card-title" >{temp.name}</h5>
                                                </Link>
                                                <h6 className="card-subtitle mt-2 text-muted">{temp.id}</h6>
                                                <p className="card-text" style={{ color: "black" }}>Students enrolled: {temp.studentCount}</p>
                                                <a href="#" className="btn btn-primary">Add Class</a>
                                            </div>
                                        </div>
                                    </div>
                                )
                            }
                            else
                            {
                                return (
                                    <div className="col-4" style={{ padding: "10px" }}>
                                        <div className="card" >
                                            
                                            <div className="card-body">
                                                <Link to={`../Banner/${temp.name}`} >
                                                    <h5 className="card-title" >{temp.name}</h5>
                                                </Link>
                                                <h6 className="card-subtitle mt-2 text-muted">{temp.id}</h6>
                                                <p className="card-text" style={{ color: "black" }}>Students enrolled: {temp.studentCount}</p>
                                            </div>
                                        </div>
                                    </div>
                                )
                            }
                            
                        }
                        )
                        }
                    </div >
                </div>

            </main>

        )
    }
}

export default Classes


