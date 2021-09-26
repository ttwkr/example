using System.Collections;
using System.Collections.Generic;
using Script;
using UnityEngine;

public class Test : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        Player myPlayer = new Player();
        myPlayer.Attack();
        myPlayer.Damage(100);

        // 현재 위치 정의
        Vector2 playerPos = new Vector2(8.0f, 5.0f);
        
        // 위치 이동
        // x = 5 만큼
        // y = 4.5 만큼
        playerPos.x += 5.0f;
        playerPos.y += 4.5f;
        
        Debug.Log(playerPos);
        
        // 거리 구함
        Vector2 startPos = new Vector2(2.0f, 1.0f);
        Vector2 endPos = new Vector2(8.0f, 5.0f);
        Vector2 dir = endPos - startPos;
        float len = dir.magnitude;
        Debug.Log(len);
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
