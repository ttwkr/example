import React from "react";
import Titles from "./component/main/title"
import {Link} from "react-router-dom";
import {Button} from "react-bootstrap";

const App = () => {
    return (
        <div className="App">
            <Titles/>
            <Button variant="outline-primary">
                <Link to="post/save" style={{ textDecoration: 'none' }}>글 등록</Link>
            </Button>
        </div>
    );
}

export default App;
