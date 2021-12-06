import React, { Component } from 'react'
import { Link } from 'react-router-dom';
import '../index.css';
import './Main.css'
import pic from '../Filos-logos-2/Filos-logos_black.png'
class Home extends Component {



    render() {

        //items might have to come from API fetch

        return (
            <main>
            <h1 style={{
                padding: '30px'
            }}> <img src={pic} style={{width:200, height: 200, padding: '0px'}}></img>Welcome to Filos
            
            <h4> Filos aims to connect students with similar interests with each other. 
            Our application introduces students taking the same class to each other and 
            gives them the opportunity to meet new friends before even going to the first lecture.</h4>
            </h1>
            </main>
        );

    }
}


export default Home;