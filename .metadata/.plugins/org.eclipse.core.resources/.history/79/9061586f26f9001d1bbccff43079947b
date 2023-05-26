const validateForm= ({courseName, facultyName, startDate, endDate, material, recording}) => {

    if (courseName.length <= 0) return { msg: 'Invalid course name', sts: false }
    if (facultyName.length <= 0) return { msg: 'Invalid faculty name', sts: false }
    if (!validateDate(startDate,endDate)) return { msg: 'Choose start date before end date', sts: false }
    // if (material.length <= 0) return { msg: 'Invalid material link', sts: false }
    // if (recording.length <= 0) return { msg: 'Invalid recording link', sts: false }
  

    return { sts: 'success', msg: 'All fields are valid' }

    
}

function validateDate(startDate, endDate) {
    
    const start = new Date(startDate);
    const end = new Date(endDate);
    return start<end;
}


const readIdQueryParam = () => {
    const params = new Proxy(new URLSearchParams(window.location.search), {
        get: (searchParams, prop) => searchParams.get(prop),
    });
    return params.id
}

console.log(readIdQueryParam())

function apiGetCourseDetails() {
    const id = readIdQueryParam()

    axios.get(`http://localhost:8080/course/${id}`)
        .then(httpReponse => httpReponse.data)
        .then(data => populateForm(document.getElementById('formCourse'), data.bd))
        .catch(err => console.log(err))
}

function apiUpdateExistingForm(course, form) {
    console.log(course.id)
    axios.put(`http://localhost:8080/course/`, course)
        .then(httpResponse => httpResponse.data)
            // window.alert("Course updated successfully")
            // window.location.href= "../Faculty/list-course.html"
        
        .then(data => {
            console.log(data.msg)
            // console.log(data)
            console.log(course.id)
            window.alert("Course updated successfully")
            window.location.href= "../Faculty/list-course.html"
        
        })
        .catch(err => console.log(err))
}

function populateForm(form, data) {
    console.log(data)
    const { elements } = form; 
    console.log(elements)

    const entries = Object.entries(data) 
    console.log(entries)

    for (const entry of entries) {
        
        console.log(entry)
        

        const [key, value] = entry
        const inputField = elements.namedItem(key)
        console.log(inputField)
        if (inputField) inputField.value = value
    }

}

function setupForm() {
    
    const err=document.getElementById('errDiv')
    err.style.display='none'
    const formCourse = document.getElementById('formCourse')
    formCourse.onsubmit = ev => { 
        const formData = new FormData(ev.target)

        ev.preventDefault() 
        console.log(ev)

        const rawData = Object.fromEntries(formData.entries()) 
        console.log(rawData)

        const id = readIdQueryParam()

        const course = { ...rawData, id }
        console.log(course)

        const {sts, msg} = validateForm(course)
        if (sts) apiUpdateExistingForm(course, formCourse)
        else{
            err.style.display='block'
            err.innerHTML=`<strong>${msg}</strong>`
        }

         
    }
}


setupForm()

apiGetCourseDetails()



