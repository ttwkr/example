import React from "react";
import {Button} from "react-bootstrap";
import {Link} from "react-router-dom";

const Main = () => {
    return (
        <div>
            <h1>스프링 부트 웹 서비스 첫번째 프로젝트</h1>
            <Button variant="outline-primary">
                <Link to="post/save" style={{ textDecoration: 'none' }}>글 등록</Link>
            </Button>
        </div>
    )
}

export default Main;