import React, {useEffect, useState} from 'react';
import axios from "../components/AxiosConfig";

export function StudentsInCourse(props) {

    const [studentsInCourse, setStudentsInCourse] = useState(null);
    const [course, setCourse]=useState(null);

    useEffect(() => {
        axios.get(`students/in-course/${props.courseId}`)
            .then(res => {
                setStudentsInCourse(res.data)
            })
        axios.get(`courses/${props.courseId}`)
            .then(res =>{
                setCourse(res.data)
            })
    }, []);
    return (
        <div>
            <header>
                <h1>Students in {course != null && course.name} </h1>
            </header>
            <div>
                <ul>
                    {studentsInCourse && studentsInCourse.length > 0 && studentsInCourse.map(student =>
                        <li key={student.username} style={{listStyleType: "none"}}>
                            {student.name + " " + student.surname}
                        </li>)}
                </ul>
            </div>
        </div>
    )
}
