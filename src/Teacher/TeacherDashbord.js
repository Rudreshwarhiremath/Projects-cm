import React from 'react';
import { Link ,NavLink} from 'react-router-dom';
import { Nav, Navbar } from 'react-bootstrap';

function NavBar() {
  return (

    <Navbar collapseOnSelect expand="sm" bg="dark" variant="dark">
      <Navbar.Toggle aria-controls="navbarScroll" data-bs-target="#navbarScroll"/>
      <Navbar.Collapse id="navbarScroll">
        <Nav>
        <NavLink className="btn btn-primary nav-link"  as={Link} to="/">Home</NavLink>
            {/* <NavLink className="btn btn-primary nav-link"  as={Link} to="/reg">RegistrationPage</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/login">Login</NavLink>*/}
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/course">createcourse</NavLink> 
            {/* <NavLink className="btn btn-primary nav-link"  as={Link} to="/list">Enroll in course</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/schedule">CourseSchedule</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/grades">Grades and Feedback</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/EnrolledLIst">Enrolled list</NavLink> */}
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/GradesAndFeedback">Grades And FeedBack</NavLink> 
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  )
  }
export default NavBar;