import React, { useState } from 'react'
import './AddAccount.css'
let account_number = 100000;

const AddAccount = () => {

  const [user,setuser] = useState(0)
  const [username,setusername] = useState('')
  const [email,setemail] = useState('')
  const [amount,setamount] = useState('')


  const addUser = async (e) =>{

    e.preventDefault();

    const response = fetch('https://backend-bankapp.onrender.com/addaccount',{
    method : 'POST',
    headers : {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
    body : JSON.stringify({
      username,
      email,
      amount,
    })
   })
   .then(res => setuser(res.status))
  }

  if(user === 200)
    alert('User Created')

  return (
    <div className="container1">
        <div className="container2">
          <form className='Form' onSubmit={addUser}>
          <h3 className='Heading'>Add Your Account </h3>
          <input type="text" placeholder='Name' value={username} onChange={e => setusername(e.target.value)} />
          <input type="text" placeholder='Email' value={email} onChange={e=> setemail(e.target.value)} />
          <input type="number" placeholder='Amount' value={amount} onChange={e => setamount(e.target.value)} />
          <button>Add User</button>
          </form>
        </div>
    </div>
  )
}

export default AddAccount