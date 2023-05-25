import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './GradeFeedback.css';

const GradeFeedback = () => {
  const [grades, setGrades] = useState([]);
  const [userName , setUserName] = useState();
  useEffect(() => {
    const data = localStorage.getItem('userName');
    console.log(data);
    setUserName(data);
  }, []);

  useEffect(() => {
    if (userName) {
      // Fetch the grades and feedback for the student from the server
      axios
        .get(`http://localhost:9999/axis/user/getGrades?userName=${encodeURIComponent(userName)}`)
        .then((response) => {
          console.log(response.data);
          setGrades(response.data);
          console.log(grades.length)
        })
        .catch((error) => {
          console.error('Error fetching grades:', error);
        });
    }
  }, [userName]);

  return (
    <div className="grade-feedback-container">
      <h2>Grades and Feedback</h2>
      {grades.length > 0 ? (
        <table className="grade-feedback-table">
          <thead>
            <tr>
              <th>Assignment ID</th>
              <th>Grade</th>
              <th>Feedback</th>
              <th>Submission ID</th>
              <th>Student Id</th>
            </tr>
          </thead>
          <tbody>
            {grades.map((grade) => (
              <tr key={grade.assignmentId}>
                <td>{grade.assignmentId}</td>
                <td>{grade.grade}</td>
                <td>{grade.feedBack}</td>
                <td>{grade.submissionsId}</td>
                <td>{grade.studentId}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No grades available.</p>
      )}
    </div>
  );
};

export default GradeFeedback;


// import React, { useState, useEffect } from 'react';
// import axios from 'axios';

// const GradesFeedback = () => {
//   const [gradesFeedback, setGradesFeedback] = useState([]);

//   useEffect(() => {
//     // Fetch grades and feedback from the database
//     axios.get(`http://localhost:9999/axis/user/getGrades?userName=${encodeURIComponent(userName)}`)
//       .then((response) => {
//         setGradesFeedback(response.data);
//       })
//       .catch((error) => {
//         console.error('Error fetching grades and feedback:', error);
//       });
//   }, []);

//   return (
//     <div>
//       <h2>Grades and Feedback</h2>
//       <table>
//         <thead>
//           <tr>
//             <th>Assignment ID</th>
//             <th>Grade</th>
//             <th>Feedback</th>
//           </tr>
//         </thead>
//         <tbody>
//           {gradesFeedback.map((item) => (
//             <tr key={item.assignmentId}>
//               <td>{item.assignmentId}</td>
//               <td>{item.grade}</td>
//               <td>{item.feedback}</td>
//             </tr>
//           ))}
//         </tbody>
//       </table>
//     </div>
//   );
// };

// export default GradesFeedback;

