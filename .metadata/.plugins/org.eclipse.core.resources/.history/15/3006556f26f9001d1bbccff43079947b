const readIdQueryParam = () => {
    const params = new Proxy(new URLSearchParams(window.location.search), {
        get: (searchParams, prop) => searchParams.get(prop),
    });
    return params.id
  }
  
  function setUpTable() {
    const table = document.getElementById('tableCourse')
    apiFetchCourse(table)
  }
  
  setUpTable()
  
  function populateActualData(table, courses) {
    const grid = document.createElement('div')
    grid.classList.add('grid')
    if (!Array.isArray(courses)) {
      courses = [courses]
    }
    for (const course of courses) {
      const { courseName, facultyName, material, recording, startDate, endDate } = course
      const card = document.createElement('div')
      card.classList.add('card')
      const header = document.createElement('h2')
      header.innerHTML = courseName
      const faculty = document.createElement('p')
      faculty.innerHTML = `By: ${facultyName}`
      const dates = document.createElement('p')
      dates.innerHTML = `Schedule:${startDate} to ${endDate}`
      const materialLink = document.createElement('a')
      materialLink.innerHTML = 'Material'
      materialLink.setAttribute('href', material)
      const blankLine = document.createElement('br')
      const recordingLink = document.createElement('a')
      recordingLink.innerHTML = 'Recording'
      recordingLink.setAttribute('href', recording)
      card.appendChild(header)
      card.appendChild(faculty)
      card.appendChild(dates)
      card.appendChild(materialLink)
      card.appendChild(blankLine)
      card.appendChild(recordingLink)
      grid.appendChild(card)
    }
    table.appendChild(grid)
  } 
  
  
  function apiFetchCourse(table) {
    const id = readIdQueryParam()
    axios.get(`http://localhost:8080/course/${id}`)
        .then(res => {
            const { data } = res
            console.log(data)
            const { sts, msg, bd } = data
            populateActualData(table, bd)
        })
        .catch(err => console.log(err))
  }
 