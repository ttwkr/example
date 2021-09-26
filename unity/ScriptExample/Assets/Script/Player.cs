using UnityEngine;

namespace Script
{
    public class Player
    {
        private int hp = 100;
        private int power = 80;

        public void Attack()
        {
            Debug.Log(this.power + "대미지를 입혔다.");
        }

        public void Damage(int damage)
        {
            this.hp -= damage;
            Debug.Log(damage + "대미지를 입었다.");
        }
    }
}