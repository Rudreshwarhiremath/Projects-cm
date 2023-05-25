// import React, { useState, useEffect } from 'react';
// import axios from 'axios';
// import './CourseList.css';

// const CourseList = () => {
//   const [courses, setCourses] = useState([]);

//   useEffect(() => {
//     // Fetch all available courses from the server
//     axios.get('http://localhost:9999/axis/user/courses')
//       .then((response) => {
//         console.log('Available courses:', response.data);
//         setCourses(response.data);
//       })
//       .catch((error) => {
//         console.error('Error fetching courses:', error);
//       });
//   }, []);

//   return (
//     <div className="course-list-container">
//       <h2>Available Courses</h2>
//       {courses.length > 0 ? (
//         <ul className="course-list">
//           {courses.map((course) => (
//             <li key={course.courseId} className="course-item">
//               <div className="course-details">
//                 <h3 className="course-name">{course.courseName}</h3>
//                 <p className="course-dates">
//                   Start Date: {course.startDate} | End Date: {course.endDate}
//                 </p>
//                 <p className="course-teacher">Teacher ID: {course.teacherId}</p>
//               </div>
//               <button className="enroll-button">Enroll</button>
//             </li>
//           ))}
//         </ul>
//       ) : (
//         <p>No courses available.</p>
//       )}
//     </div>
//   );
// };



// export default CourseList;
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './CourseList.css';

const CourseList = () => {
  const [courses, setCourses] = useState([]);
  const [enrollmentData, setEnrollmentData] = useState([]);

  useEffect(() => {
    // Fetch all available courses from the server
    axios.get('http://localhost:9999/axis/user/courses')
      .then((response) => {
        console.log('Available courses:', response.data);
        setCourses(response.data);
      })
      .catch((error) => {
        console.error('Error fetching courses:', error);
      });
  }, []);

  const handleEnroll = (courseId) => {
    // Create an enrollment object with the courseId and any additional data needed
    const enrollment = {
      courseId: courseId,
      // Add any other relevant enrollment data here
    };

    // Send the enrollment data to the server to save in the database
    axios.post('http://localhost:9999/axis/user/enrole', enrollment)
      .then((response) => {
        console.log('Enrollment successful:', response.data);
        setEnrollmentData(response.data); // Update enrollment data state if needed
      })
      .catch((error) => {
        console.error('Error enrolling in the course:', error);
      });
  };

  return (
    <div className="course-list-container">
      <h2>Available Courses</h2>
      {courses.length > 0 ? (
        <div className="course-list">
          {courses.map((course) => (
            <div key={course.courseId} className="course-card">
              <h3 className="course-name">{course.courseName}</h3>
              <p className="course-dates">
                Start Date: {course.startDate} | End Date: {course.endDate}
              </p>
              <p className="course-teacher">Teacher ID: {course.teacherId}</p>
              <button className="enroll-button" onClick={() => handleEnroll(course.courseId)}>Enroll</button>
            </div>
          ))}
        </div>
      ) : (
        <p>No courses available.</p>
      )}
    </div>
  );
};

export default CourseList;

