import React, { Component } from 'react'

class Register extends Component {
  constructor(props) {
    super(props)
    this.state = {
      fullName: '',
      dob: '',
      year: '',
      major: '',
      interests: '',
      email: '',
      linkedIn: '',
      insta: '',
      snap: '',
    }
  }


  handleSubmit = (event) => {
    event.preventDefault()
    const data = this.state
    console.log("Final data is", data)
    this.props.onFirstTime(false);
  }

  handleInputChange = (event) => {
    event.preventDefault()
    this.setState({
      [event.target.name]: event.target.value
    })
  }

  async postData() {

    const data = this.state
    console.log("Final data is", data)

    try {

      //change fetch to correct link from backend ppl
      let result = await fetch('http://localhost:8080/createStudent', {
        method: 'post',
        headers: {
          'Accept': 'application/json',
          'Content-type': 'application/json',
        },
        body: JSON.stringify(data)
        // ({data}) ? 
      });

      console.log('Result: ' + result)
    } catch (e) {
      console.log(e)
    }
  }

  render() {
    const { fullName } = this.state
    const { dob } = this.state
    const { year } = this.state
    const { major } = this.state
    const { interests } = this.state
    const { email } = this.state
    const { linkedIn } = this.state
    const { insta } = this.state
    const { snap } = this.state
    return (

      <main>
        <div className="container">

          <h1>Registration Form</h1>
          <div className="row">
            <div className="col-3">

            </div>
            <div className="col-6">
              <form onSubmit={this.handleSubmit}>

                <div className="form-group">
                  <label for="name">Full Name: </label>
                  <input class="form-control" type='text' placeholder='Full Name' value={fullName} name='fullName' id="name" onChange={this.handleInputChange} />
                </div>

                <div className="form-group">
                  <label>Date of Birth:</label>
                  <input class="form-control" type='text' placeholder='Date of Birth' value={dob} name='dob' onChange={this.handleInputChange} />
                </div>

                <div className="form-group">
                  <label>College Year:</label>
                  <input class="form-control" type='text' placeholder='College Year' value={year} name='year' onChange={this.handleInputChange} />
                </div >

                <div className="form-group">
                  <label>Major:</label>
                  <input class="form-control" type='text' placeholder='Major' value={major} name='major' onChange={this.handleInputChange} />
                </div >

                <div className="form-group">
                  <label>Interests: </label>
                  <input class="form-control" type='text' placeholder='Interests' value={interests} name='interests' onChange={this.handleInputChange} />
                </div >

                <div className="form-group">
                  <label>Email: </label>
                  <input class="form-control" type='text' placeholder='Email' value={email} name='email' onChange={this.handleInputChange} />
                </div >

                <div className="form-group">
                  <label>LinkedIn:</label>
                  <input type='text' class="form-control" placeholder='LinkedIn' value={linkedIn} name='linkedIn' onChange={this.handleInputChange} />
                </div >

                <div className="form-group">
                  <label>Instagram: </label>
                  <input type='text' class="form-control" placeholder='Instagram' value={insta} name='insta' onChange={this.handleInputChange} />
                </div>

                <div className="form-group">
                  <label>Snapchat: </label>
                  <input type='text' class="form-control" placeholder='Snapchat' value={snap} name='snap' onChange={this.handleInputChange} />
                </div >

                <button class="btn btn-primary mt-2" onClick={() => this.postData()}>Submit </button>
              </form >
            </div>
            <div className="col-3">
            </div>
          </div>
        </div>
      </main >

    )
  }
}

export default Register;

//https://www.youtube.com/watch?v=fcMNZ7j4JSg original form 
//https://www.youtube.com/watch?v=8SkiIAbFbNs post to api with json
//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON/stringify json doc