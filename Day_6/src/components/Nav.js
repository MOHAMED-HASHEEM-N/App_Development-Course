import React from 'react'
import {Link} from 'react-router-dom'

const Nav = () => {
  return (
    <div className="navigation">
        <div className="left">
          {/* <h2>Banking App</h2> */}
        </div>
        <div className="right">
          <ul>
            <Link to='/' className='text-link'><li>Home</li> </Link>
            <Link to='/addaccount' className='text-link'><li>Add Account</li></Link> 
            <Link to='/accounts' className='text-link'><li>Accounts</li></Link> 
            {/* <Link to='/transcation' className='text-link'><li>Transfer</li></Link>  */}
            <Link to='/' className='text-link'><li>About Us</li></Link>
            <Link to='/login' className='text-link'><li>Login</li></Link>
          </ul>
        </div>
      </div>
  )
}

export default Nav