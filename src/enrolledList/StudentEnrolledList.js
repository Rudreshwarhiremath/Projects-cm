import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './StudentEnrolled.css';

const EnrolledStudents = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    // Fetch the enrolled students for the teacher from the server
    axios.get('http://localhost:9999/axis/enrolList')
      .then((response) => {
        console.log('Enrolled students:', response.data);
        setStudents(response.data);
      })
      .catch((error) => {
        console.error('Error fetching enrolled students:', error);
      });
  }, []);

  return (
    <div className="enrolled-students-container">
      <h2>Enrolled Students</h2>
      {students.length > 0 ? (
        <table className="enrolled-students-table">
          <thead>
            <tr>
              <th>User Name</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.userName}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No students enrolled.</p>
      )}
    </div>
  );
};

export default EnrolledStudents;
