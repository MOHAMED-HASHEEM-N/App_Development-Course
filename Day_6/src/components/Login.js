
import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { validateAll } from 'indicative/validator';
import './Login.css';
import { Button } from '@mui/material';
class Form extends Component {
  

  state = {
    fullname: '',
    email: '',
    password: '',
    // Using indicative we also need to add in a password confirmation in name input and in state.
    password_confirmation: '',
  }
  
  handleInputChange=(event)=>{
    this.setState({
      [event.target.name]: event.target.value
    })
  }
  
  handleSubmit=(event)=> {
    event.preventDefault();
    this.props.history.push('/home');
    // We are validating the user using indicative package.
    // taking the input data from state.
    const data = this.state;
    const rules = {
      fullname: 'required|string',
      email: 'required|email',
      password: 'required|string|min:8|confirmed' // confirmed will check for the password confirmation.
    }
    
    const messages = {
      required: 'This {{ field }} is required.',
      'email.email': 'This email is invalid.',
      'password.confirmed': 'The password does not match'
    }

    
    validateAll(data, rules, messages)
    .then(() => {
      console.log('success')
    })
    .catch(errors => {
      // console.log(errors);
      // Show errors to user.
      const formattedErrors = {}
      errors.forEach(error => formattedErrors[error.field] = error.message)
      this.setState({errors: formattedErrors})
    })
  };
  
  
  
  render() {
    return (
      <div className='wrapper'>
        <div className='form-wrapper'>
          <h2><b>Login Into Account</b></h2>
          <form onSubmit={this.handleSubmit}>
            <div className='fullName'>
              <label htmlFor="fullName">Full Name</label>
              <input type='text' name='fullName' onChange={this.handleInputChange}/>
            </div>
            <div className='email'>
              <label htmlFor="email">Email</label>
              <input type='email' name='email' onChange={this.handleInputChange}/>
            </div>
            <div className='password'>
              <label htmlFor="password">Password</label>
              <input type='password' name='password' onChange={this.handleInputChange}/>
            </div>
            <div className='password'>
              <label htmlFor="password">Password (Confirm)</label>
              <input type='password' name='password_confirmation' onChange={this.handleInputChange}/>
            </div>
            <div className='info'>
              <small>Password must be eight characters in length.</small>
            </div>
            <div className='submit'>
              <button>Login <Link to="/home"></Link></button>
            </div>
            <p>Don't Have Account?</p><Link to="/signup"><Button>Register</Button></Link>
          </form>
        </div>
      </div>
    );
  }
}

export default Form;

// import React from 'react'
// import { useForm } from "react-hook-form";
// import { Button } from '@mui/material';
// import { Link } from 'react-router-dom';
// import './Login.css';

// export default function Form() {
//         const {
//           register,
//           handleSubmit,
//           formState: { errors },
//         } = useForm({
//           mode: "all",
//         });
//         const onSubmit = (data) => console.log(data);
//         console.log(errors);      
//   return (

    // <form onSubmit={handleSubmit(onSubmit)} autoComplete="off">

  //   <div className='container'>
  // <form className='Form' onSubmit={handleSubmit(onSubmit)}>
  //   <h3 className='Heading'>Login Into Account </h3>
  //     <input
  //       {...register("userName", {
  //         required: "Username is Required...",
  //         minLength: {
  //           value: 3,
  //           message: "Username must be atleast 3 characters long...",
  //         },
  //         maxLength: {
  //           value: 30,
  //           message: "Username must be atmost 30 characters long...",
  //         },
  //       })}
  //       placeholder="Username"
  //       />
  //     <p>{errors.userName?.message}</p>
  //     <input
  //       {...register("email", {
  //         required: "Email is Required...",
  //         pattern: {
  //           value:
  //           /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
  //           message: "Email must be valid",
  //         },
  //       })}
  //       placeholder="Email"
  //       />
  //     <p>{errors.email?.message}</p>
  //     <input
  //       {...register("password", {
  //         required: "Password is Required...",
  //         pattern: {
  //           value:
  //           /^(?=.*[0-9])(?=.*[!@#$%^&*.,])[a-zA-Z0-9!@#$%^&*.,]{6,16}$/,
  //           message:
  //           "Password Must Contain Atleast 6 Characters, One Uppercase, One Lowercase, One Number and One Special Case Character",
  //         },
  //       })}
  //       placeholder="Password"
  //       />
  //     <p>{errors.password?.message}</p>
      {/* <select
        {...register("gender", {
          required: "Gender is Required...",
        })}
      >
      <option value="">Select Gender</option>
      <option value="female">Female</option>
      <option value="male">Male</option>
      <option value="other">Other</option>
      </select>
    <p>{errors.gender?.message}</p> */}
      {/* <input type="Submit" />
      <p>Don't Have Account?</p>
      <Button className="primary"><Link to="/signup">Register</Link></Button>
    </form>
    </div> */}
//   );
// }