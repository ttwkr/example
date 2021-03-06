using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Car : MonoBehaviour
{
    float speed = 0;
    private Vector2 startPos;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            startPos = Input.mousePosition;
        } else if (Input.GetMouseButtonUp(0))
        {
            Vector2 endPos = Input.mousePosition;
            float swipeLength = this.startPos.x - endPos.x ;
            this.speed = swipeLength / 5000.0f;
            if (swipeLength > 0)
            {
                GetComponent<AudioSource>().Play();
            }
        }
        
        transform.Translate(this.speed * -1, 0, 0);
        this.speed *= 0.98f;
    }
    
}
