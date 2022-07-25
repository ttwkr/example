import React from "react";
import {Link} from "react-router-dom";

const CreatePost = () => {
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
        </div>
    )
}

export default CreatePost;
