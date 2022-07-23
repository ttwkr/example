import React from "react";
import Titles from "./component/main/title"
import {Link} from "react-router-dom";

const App = () => {
    return (
        <div className="App">
            <Titles/>
            <Link to="post/save">글 등록</Link>
        </div>
    );
}

export default App;
