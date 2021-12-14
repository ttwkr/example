using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class GameDirector : MonoBehaviour
{
    GameObject flag;
    GameObject car;
    GameObject distance;
    public float carPosition = 0;
    private float flagPos;
    private float carPos;
    private float length;

    // Start is called before the first frame update
    void Start()
    {
        this.car = GameObject.Find("car");
        this.flag = GameObject.Find("flag");
        this.distance = GameObject.Find("distance");
    }

    // Update is called once per frame
    void Update()
    {
        flagPos = this.flag.transform.position.x;
        carPos = this.car.transform.position.x - carPosition;
        length = (flagPos - carPos) * -1;
        if (length >= 0)
        {
            this.distance.GetComponent<Text>().text = "목표 지점까지 " + length.ToString("F2") + "m";    
        } else if (length <= -0.1 ){
            this.distance.GetComponent<Text>().text = "Game Over!!";
        }
        
    }
}