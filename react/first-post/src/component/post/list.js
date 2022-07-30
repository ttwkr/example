import React, {useEffect, useState} from 'react'
import axios from "axios";
import {Table} from "react-bootstrap";

const List = () => {
    const [posts, setPosts] = useState([])

    useEffect(() => {
        // post 갖고옴
        axios.get("http://localhost:8080/")
            .then(res => setPosts(res.data))
            .catch(err => console.log(err))
    }, [])

    return (
        <div>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>#</th>
                    <th>title</th>
                    <th>content</th>
                    <th>author</th>
                </tr>
                </thead>
                <tbody>
                {
                    posts.map((post, i) => {
                        return (
                            <Post
                                id={post.id}
                                title={post.title}
                                content={post.content}
                                author={post.author}
                            />
                        )
                    })
                }
                </tbody>
            </Table>
        </div>
    )
}

const Post = ({id, title, content, author}) => {
    return (
        <tr>
            <td>{id}</td>
            <td>{title}</td>
            <td>{content}</td>
            <td>{author}</td>
        </tr>
    )
}

export default List