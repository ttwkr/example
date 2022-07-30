import React, {useState} from "react";
import axios from "axios";
import {Button, Form} from "react-bootstrap";
import {Link} from "react-router-dom";

const CreatePost = () => {
    const [form, setForm] = useState(
        {
            title: '',
            author: '',
            content: ''
        }
    )

    const changeForm = (e) => {
        console.log(form)
        const {id, value} = e.target
        setForm({
            ...form,
            [id]: value
        })
    }

    const submitForm = async () => {
        console.log(form)
        await axios.post(
            "http://localhost:8080/api/v1/posts",
            form
        ).then(
            r => console.log(r)
        ).catch(
            e => console.log(e)
        )

    }

    return (
        <div>
            <Form onChange={changeForm}>
                <Form.Group className="mb-3" controlId="title">
                    <Form.Label>Title</Form.Label>
                    <Form.Control type="text" placeholder="제목"/>
                </Form.Group>

                <Form.Group className="mb-3" controlId="content">
                    <Form.Label>Content</Form.Label>
                    <Form.Control as="textarea" aria-label="With textarea" placeholder="내용"/>
                </Form.Group>

                <Form.Group className="mb-3" controlId="author">
                    <Form.Label>author</Form.Label>
                    <Form.Control type='email' placeholder="name@example.com"/>
                </Form.Group>
            </Form>
            <Button variant="primary" type="submit" onClick={submitForm}>
                등록
            </Button>
            <Button>
                <Link to="/" style={{ textDecoration: 'none' }}>뒤로</Link>
            </Button>
        </div>
    )
}

export default CreatePost;
