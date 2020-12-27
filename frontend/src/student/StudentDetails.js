import React, {useEffect, useState} from "react";
import axios from'../components/AxiosConfig'
import {navigate} from "@reach/router";
import Button from "react-bootstrap/Button";

export default function StudentsDetails(props){
    const [studentDetails, setStudentDetails]=useState(null);

    useEffect(()=> {
        axios.get(`/students/${props.studentUsername}`)
            .then(r => {
                setStudentDetails(r.data)
            })
    },[])

    const handleDelete = () => {
        axios.delete(`/students/${props.studentUsername}`)
            .then(() => {
                navigate("/students")
                    .then(() => window.location.reload())
            })
    }
    return(
        <div>
            <h1>Student</h1>

            {studentDetails &&
            <p key={studentDetails.username}>
                {studentDetails.name + " " + studentDetails.surname}
            </p>}

            <Button onClick={handleDelete}>
                Delete
            </Button>
        </div>
    )
}