using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RouletteController : MonoBehaviour
{
    float rotSpeed = 0;
    bool isRotate;

    void Start()
    {
        isRotate = false;
    }

    // Update is called once per frame
    void Update()
    {
        // 클릭하면 회전속도 설정
        if (Input.GetMouseButtonDown(0) && isRotate==false)
        {
            this.isRotate = true;
            this.rotSpeed = 10;
        }
        else if (Input.GetMouseButtonDown(0) && isRotate == true)
        {
            // 룰렛 속도 감속
            this.rotSpeed = 0;
            this.isRotate = false;
        } 
        
        //룰렛 회전
        transform.Rotate(0,0, this.rotSpeed);

    }
}
