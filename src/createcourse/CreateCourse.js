import React, { useState } from 'react';
import axios from 'axios';
import './CreateCourse.css';

const CreateCourse = () => {
  const [teacherId, setTeacherId] = useState('');
  const [courseName, setCourseName] = useState('');
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');

  const handleTeacherIdChange = (event) => {
    setTeacherId(event.target.value);
  };

  const handleCourseNameChange = (event) => {
    setCourseName(event.target.value);
  };

  const handleStartDateChange = (event) => {
    setStartDate(event.target.value);
  };

  const handleEndDateChange = (event) => {
    setEndDate(event.target.value);
  };

  const handleCreateCourse = (event) => {
    event.preventDefault();

    // Prepare the course data
    const courseData = {
      teacherId,
      courseName,
      startDate,
      endDate,
    };

    // Send the course data to the server
    fetch('http://localhost:9999/axis/addCourse', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        },
        body: JSON.stringify(courseData),
         
      })
      .then((response) => {
        console.log('Course created:', response.ok);

        // Reset the form
        setTeacherId('');
        setCourseName('');
        setStartDate('');
        setEndDate('');
      })
      .catch((error) => {
        console.error('Error creating course:', error);
      });
  };

  return (
    <div className="create-course-container">
      <h2>Create Course</h2>
      <form onSubmit={handleCreateCourse}>
        <div className="form-group">
          <label htmlFor="teacherId">Teacher ID:</label>
          <input
            type="text"
            id="teacherId"
            name="teacherId"
            value={teacherId}
            onChange={handleTeacherIdChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="courseName">Course Name:</label>
          <input
            type="text"
            id="courseName"
            name="courseName"
            value={courseName}
            onChange={handleCourseNameChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="startDate">Start Date:</label>
          <input
            type="date"
            id="startDate"
            name="startDate"
            value={startDate}
            onChange={handleStartDateChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="endDate">End Date:</label>
          <input
            type="date"
            id="endDate"
            name="endDate"
            value={endDate}
            onChange={handleEndDateChange}
            required
          />
        </div>
        <button type="submit">Create Course</button>
      </form>
    </div>
  );
};

export default CreateCourse;
