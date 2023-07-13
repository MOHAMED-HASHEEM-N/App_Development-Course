// import logo from './logo.svg';
// import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;

// import React from 'react';
// import './App.css';

// import {Container, Row, Col} from 'react-bootstrap';
// import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';

// import NavigationBar from './components/NavigationBar';
// import Welcome from './components/Welcome';
// import Userslist from './components/Userslist';
// import Accountslist from './components/Accountslist';
// import Loanslist from './components/Loanslist';
// import Adduser from './components/Adduser';
// import Addaccount from './components/Addaccount';
// import Deposit from './components/Deposit';
// import Withdraw from './components/Withdraw';
// import GetLoan from './components/GetLoan';

// function App() {
//   const marginTop = {
//   	marginTop:"20px"
//   }
//   return (
//     <Router className="App">
//     	<NavigationBar/>
//     	<Container>
//     		<Row>
//     		<Col lg={12} style={marginTop}>
//     			<Routes>
//     				<Route path="/" element={<Welcome />} />
//     				<Route path="/Userslist" element={<Userslist />}/>
//     				<Route path="/Adduser" element={<Adduser />}/>
//     				<Route path="/Accountslist" element={<Accountslist />}/>
//     				<Route path="/Addaccount" element={<Addaccount />}/>
//     				<Route path="/Loanslist" element={<Loanslist />}/>
//     				<Route path="/Deposit" element={<Deposit />}/>
//     				<Route path="/Withdraw" element={<Withdraw />}/>
//     				<Route path="/GetLoan" element={<GetLoan />}/>
//     			</Routes>
// 			</Col>
//     		</Row>
//     	</Container>
//       	<p>
//           Welcome to Banking Application
//        	</p>
//     </Router>
//   );
// }

// export default App;


// import React, { Component } from 'react';
// import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
// import './App.css';
// import './style.css';
// import LoginContainer from './containers/LoginContainer';
// import HomeC from './pages/HomeC';
// import CurrentAccountContainer from './containers/CurrentAccountContainer'; // DID HAVE LOGIN CONTAINER BELOW!!
// import HomeContainer from './containers/HomeContainer';
// import Routess from './pages/Routess';

// class App extends Component {
//   render(){
//     return (
//       <Routess />
//     );
//   }
// }

// export default App;

import './App.css';
import Home from './components/Home';
import { Routes,Route} from 'react-router-dom'
import AddAccount from './components/AddAccount';
import Nav from './components/Nav';
import Accounts from './components/Accounts';
import Login from './components/Login';
import Sidebar from './components/Sidebar';
import Signup from './components/Signup'
import { Icon } from '@mui/material';
// import Transfer from './component/Transfer';


function App() {
  return (
    <div className="App">
      <>
      <Sidebar pageWrapId={'page-wrap'} outerContainerId={'outer-container'} />
      <Nav/>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/addaccount' element={<AddAccount/>}></Route>
        <Route path='/accounts' element={<Accounts/>}></Route>
        <Route path='/login' element={<Login/>}></Route>
        <Route path='/signup' element={<Signup/>}></Route>
        {/* <Route path='/transcation' element={<Transfer/>}></Route> */}
      </Routes>
      <Icon />
       </>
     </div>
  );
}

export default App;