import { propTypes } from "react-bootstrap/esm/Image";
import { useParams } from "react-router-dom";

import List from './List';

function Profile() {


    // constructor(props) {

    let studentInfo = ["Some data", "More data", "Something else"];
    let classList = ["Class 11", "cs231"];
    let interests = ["sKIING", "BOL", "PEPE"];
    let socials = ["aALAAEJD", "HATZP"];

    //     super(props);
    //     //probably don't need this as state
    //     //props will be passed to define which student's profile to    |
    //     //load, wherever that happens has to save these guys as state \/
    //     this.state = {

    //     }
    // }

    //WORK ON THE API FETCH HERE

    // componentDidMount() {
    //     const Api = "https://api.example.com/getprof?student=" + this.props.id;

    //     fetch(Api)
    //         .then(res => res.json())
    //         .then(
    //             (result) => {
    //                 this.setState({
    //                     studentInfo: result.studentInfo,
    //                     classList: result.classList,
    //                     interests: result.interests,
    //                     socials: result.socials,
    //                 });
    //             },
    //             // Note: it's important to handle errors here
    //             // instead of a catch() block so that we don't swallow
    //             // exceptions from actual bugs in components.
    //             (error) => {
    //                 this.setState({
    //                     isLoaded: true,
    //                     error
    //                 });
    //             }
    //         )
    // }

    // render() {
    const { name = this.props.name } = useParams();
    const { img } = useParams();

    return (

        <main>

            <div className="container">
                <div className="row">
                    <div className="col-4">
                        <img className="img-fluid circle" src={img}></img>
                    </div>
                    <div className="col-8">
                        <h1 className="h1 text-black"> Name </h1>
                        {name}
                    </div>
                </div>
                <div className="row">
                    <div className="col-4">
                        <h1> Info </h1>
                        <List

                            items={studentInfo}>

                        </List>

                    </div>
                    <div className="col-8">
                        <h1> Classes </h1>
                        <List
                            items={classList}>

                        </List>
                    </div>
                </div>
                <div className="row">
                    <div className="col-4">
                        <h1>  Socials </h1>
                        <List
                            items={socials}>

                        </List>
                    </div>
                    <div className="col-8">
                        <h1> Interests </h1>
                        <List
                            items={interests}>

                        </List>
                    </div>
                </div>
            </div >
        </main>
    );
}
// }

export default Profile;