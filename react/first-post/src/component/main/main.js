import React from "react";
import {Button} from "react-bootstrap";
import {Link} from "react-router-dom";
import List from "../post/list";

const Main = () => {
    return (
        <div>
            <h1>스프링 부트 웹 서비스 첫번째 프로젝트</h1>
            <Button variant="outline-primary">
                <Link to="post/save" style={{ textDecoration: 'none' }}>글 등록</Link>
            </Button>
            <Button variant="outline-primary">
                <a href="http://localhost:8080/api/v1/posts" style={{ textDecoration: 'none' }}>로그인</a>
            </Button>
            <List/>
        </div>
    )
}

export default Main;