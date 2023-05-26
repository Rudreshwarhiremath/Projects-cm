import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NavBar from './layout/Navbar';
import Register from './user/Registration';
import Home from './pages/Home';
import LoginPage from './login/login';
import CreateCourse from './createcourse/CreateCourse';

import CourseList from './courselist/courselist';
import CourseSchedule from './Schedule/viewSchedule';
import GradeFeedback from './VGradesAndfeedback/ViewGradesAndFeedback';
import EnrolledStudents from './enrolledList/StudentEnrolledList';
import GradeAssignment from './AssignGrades/GradesFeedback';
import StudentNavbar from './layout/StudentNavbar';
import TeacherDashbord from './Teacher/TeacherDashbord';
import SendMessage from './SendMessage/SendMessage';
import Admin from './Admin/AdminDashboard';
function App() {
  return (
    <div className="App">
      <NavBar/>
      <Routes>
      <Route exact path="/" element={<Home />} />
         <Route exact path="/reg" element={<Register />} />
         <Route exact path="/login" element={<LoginPage />} />
         <Route exact path="/course" element={<CreateCourse />} />
         <Route exact path="/list" element={<CourseList />} />
         <Route exact path="/schedule" element={<CourseSchedule />} />
         <Route exact path="/grades" element={<GradeFeedback />} />
         <Route exact path="/EnrolledList" element={<EnrolledStudents />} />
         <Route exact path="/GradesAndFeedback" element={<GradeAssignment />} />
         <Route exact path="/StudentNavbar" element={<StudentNavbar />} />
         <Route exact path="/TeacherDashbord" element={<TeacherDashbord />} />
         <Route exact path="/SendMessage" element={<SendMessage />} />
         <Route exact path="/AdminDashboard" element={<Admin />} />
       
      
      </Routes>

     </div>
  );
} 
  


export default App;
