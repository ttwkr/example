import React, {useState} from "react";
import {Link} from "react-router-dom";
import axios from "axios";
import {Button} from "react-bootstrap";

const CreatePost = () => {
    const [form, setForm] = useState(
        {
            title :'',
            author:'',
            content:''
        }
    )

    const changeForm = (e) =>{
        const {name, value} = e.target
        setForm({
            ...form,
            [name]: value
        })
    }

    const submitForm = async (data) => {
        await axios.post(
            "http://localhost:8080/api/v1/posts",
            data
        )
    }

    return (
        <div>
            <h1> 글등록페이지 </h1>
            <div>
                <div>
                    제목 : <input/>
                </div>
                <div>
                    작성자 : <input/>
                </div>
                <div>
                    내용
                    <textarea/>
                </div>
            </div>
            <Link to="/">home</Link>
            <Button onClick={submitForm}>등록</Button>
        </div>
    )
}

export default CreatePost;
