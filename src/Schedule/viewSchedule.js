import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './CourseSchedule.css';

const CourseSchedule = () => {
  const [schedule, setSchedule] = useState([]);
  const [userName , setUserName] = useState();

  useEffect(() => {
        const data = localStorage.getItem('userName')
        console.log(data);
        setUserName(data);
    // Fetch the course schedule for the student from the server
    axios.get(`http://localhost:9999/axis/user/classSchedule?userName=${userName}`)
      .then((response) => {
        console.log('Course schedule:', response.data);
        setSchedule(response.data);
      })
      .catch((error) => {
        console.error('Error fetching course schedule:', error);
      });
  }, []);

  return (
    <div className="schedule-container">
      <h2>Course Schedule</h2>
      {schedule.length > 0 ? (
        <table className="schedule-table">
          <thead>
            <tr>
              <th>Course ID</th>
              <th>Teacher ID</th>
              <th>Start Time</th>
              <th>End Time</th>
            </tr>
          </thead>
          <tbody>
            {schedule.map((course) => (
              <tr key={course.classesId}>
                <td>{course.courseId}</td>
                <td>{course.teacherId}</td>
                <td>{course.startTime}</td>
                <td>{course.endTime}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No courses scheduled.</p>
      )}
    </div>
  );
};

export default CourseSchedule;
