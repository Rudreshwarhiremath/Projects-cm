// import React, { useState } from 'react';
// import LoginPage from './LoginPage';
// import DashboardPage from './DashboardPage';

// const App = () => {
//   const [isLoggedIn, setIsLoggedIn] = useState(false);

//   const handleLogin = () => {
//     // Perform login logic, e.g., authenticate user

//     // Set the isLoggedIn state to true
//     setIsLoggedIn(true);
//   };

//   return (
//     <div>
//       {isLoggedIn ? (
//         <DashboardPage />
//       ) : (
//         <LoginPage onLogin={handleLogin} />
//       )}
//     </div>
//   );
// };

// export default App;

import React , {useEffect, useState} from 'react';
import { Link ,NavLink, useLocation} from 'react-router-dom';
import { Nav, Navbar } from 'react-bootstrap';


function NavBar() {

    const [userName, setUserName] = useState('');
    const location=useLocation();
    const propsData=location.props;
    console.log(propsData)

    useEffect(() => {
        const data = localStorage.getItem('userName')
        setUserName(data);
        console.log(data);
      }, []);


      

    
  return (

    <Navbar collapseOnSelect expand="sm" bg="dark" variant="dark">
      <Navbar.Toggle aria-controls="navbarScroll" data-bs-target="#navbarScroll"/>
      <Navbar.Collapse id="navbarScroll">
        <h2>User :{userName}</h2>
        <Nav>
        {/* <NavLink className="btn btn-primary nav-link"  as={Link} to="/">Home</NavLink>
             <NavLink className="btn btn-primary nav-link"  as={Link} to="/reg">RegistrationPage</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/login">Login</NavLink>  */}
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/course">createcourse</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/list">Enroll in course</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/schedule">CourseSchedule</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/grades">Grades and Feedback</NavLink>
           <NavLink className="btn btn-primary nav-link"  as={Link} to="/EnrolledLIst">Enrolled list</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/GradesAndFeedback">Grades And FeedBack</NavLink> 
        </Nav>
      </Navbar.Collapse>
    </Navbar>
    
  )
  }
export default NavBar;
