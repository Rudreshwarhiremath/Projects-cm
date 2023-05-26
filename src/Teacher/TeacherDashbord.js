
import { Nav, Navbar } from 'react-bootstrap';
import { Link ,NavLink, useLocation} from 'react-router-dom';
import React , {useEffect, useState} from 'react';



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
        <Nav>
        <h2>User :{userName}</h2>
        <NavLink className="btn btn-primary nav-link"  as={Link} to="/">Home</NavLink>
            {/* <NavLink className="btn btn-primary nav-link"  as={Link} to="/reg">RegistrationPage</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/login">Login</NavLink>*/}
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/course">createcourse</NavLink> 
            {/* <NavLink className="btn btn-primary nav-link"  as={Link} to="/list">Enroll in course</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/schedule">CourseSchedule</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/grades">Grades and Feedback</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/EnrolledLIst">Enrolled list</NavLink> */}
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/GradesAndFeedback">Grades And FeedBack</NavLink> 
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/EnrolledLIst">Enrolled list</NavLink>
            <NavLink className="btn btn-primary nav-link"  as={Link} to="/SendMessage">Send notification</NavLink>

        </Nav>
      </Navbar.Collapse>
    </Navbar>
  )
  }
export default NavBar;