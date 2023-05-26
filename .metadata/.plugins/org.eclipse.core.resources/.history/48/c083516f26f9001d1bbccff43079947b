function setUpTable(){
    const table=document.getElementById('tableStudent')
    apiFetchAllStudents(table)
    
}

setUpTable()

function populateActualData(table, students){
    for(const student of students){
        const{id, name, email} =  student
        const updateStudentUrl= './update-student.html?id=${id}'
        const row=table.insertRow()
        row.insertCell(0).innerHTML = id
        row.insertCell(0).innerHTML = name
        row.insertCell(0).innerHTML = email
        row.insertCell(0).innerHTML = `
            <a class = "btn btn-primary" href='${updateStudentUrl}'>Update</a>
            <a class = "btn btn-danger" onclick='showConfirmDeleteModal(${id})'>Delete</a>`
    }
}

function showConfirmDeleteModal(id) {
    console.log('clicked ' + id)
    const myModalEl = document.getElementById('deleteModal');
    const modal = new bootstrap.Modal(myModalEl)
    modal.show()

    const btDl = document.getElementById('btDl')
    btDl.onclick = () => {
        apiCallDeleteStudent(id, modal)
    }
}

function apiFetchAllStudents(table){
    axios.get('http://localhost:8080/student/')
    .then(res=> {
        const{data} =res
        console.log(data)
        const{ sts, msg, bd } = data  
        populateActualData(table, bd)
    })
    .catch(err=>console.log(err))
}

function apiCallDeleteStudent(id, modal){
    const url= 'http://localhost:8080/student/${id}'
    axios.delete(url)
        .then(res => res.data) 
        .then( ({ sts, msg, bd }) =>  modal.hide() )
        .catch(console.log)
}



// function setUpTable() {
//     const table = document.getElementById('tableCourse')
//     apiFetchAllCourses(table)

// }

// setUpTable()

// function populateActualData(table, courses) {
//     for (const course of courses) {

//         const { id, courseName, facultyName, startDate, endDate, material, recording } = course

//         const row = table.insertRow()

//         row.insertCell(0).innerHTML = id
//         row.insertCell(1).innerHTML = courseName
//         row.insertCell(2).innerHTML = facultyName
//         row.insertCell(3).innerHTML = startDate
//         row.insertCell(4).innerHTML = endDate
//         row.insertCell(5).innerHTML = material
//         row.insertCell(6).innerHTML = recording
        


//     }
// }

// function apiFetchAllCourses(table) {
//     axios.get('http://localhost:8080/course/')
//         .then(res => {
//             const { data } = res
//             console.log(data)
//             const { sts, msg, bd } = data

//             populateActualData(table, bd)
//         })
//         .catch(err => console.log(err))
// }



// function deleteCourse(id) {
//     console.log(id)
//     //id = Number(id);
//     axios.delete('http://localhost:8080/course/${id}')
//         .then(function (response) {
//             console.log('Course deleted')
//             window.alert("Course deleted successfully")

//         })
//         .catch(function (error) {
//             // Handle error response
//             console.log(error)
//         })
// }
