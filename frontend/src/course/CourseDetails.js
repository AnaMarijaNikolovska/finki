import React, {useEffect, useState} from "react";
import axios from'../components/AxiosConfig'
import {navigate} from "@reach/router";
import Button from "react-bootstrap/Button";

export default function CourseDetail(props){
    const [courseDetails, setCourseDetails]= useState(null);

    useEffect(() => {
        axios.get(`/courses/${props.courseId}`)
            .then(r => {
            setCourseDetails(r.data)
        })
    }, [])

    const handleDelete = () => {
        axios.delete(`/courses/${props.courseId}`)
            .then(() => {
                navigate("/courses")
                    .then(() => window.location.reload())
            })
    }

    return(
        <div>
            <h1>Course</h1>

                {courseDetails &&
                    <p key={courseDetails.id}>
                        {courseDetails.name}
                    </p>}

            <Button onClick={handleDelete}>
                Delete
            </Button>
        </div>
    )
}