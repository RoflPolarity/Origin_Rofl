using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class move : MonoBehaviour {
    public GameObject Obj;
    private Animation Left,Rihgt,on_user,ot_user;
    public string nameanim_1, nameanim_2, nameanim_3, nameanim_4;
    public float horizantalSpeed, verticalSpeed;
    float speedX, speedY;
    void Start() {

    }

    void Update() {
        if (Input.GetKey(KeyCode.A) || Input.GetKey(KeyCode.LeftArrow))
        {
            speedX = -horizantalSpeed;
        }
        else if (Input.GetKey(KeyCode.D) || Input.GetKey(KeyCode.RightArrow))
        {
            speedX = horizantalSpeed;
        }
        if (Input.GetKey(KeyCode.W) || Input.GetKey(KeyCode.UpArrow))
        {
            speedY = verticalSpeed;
        }
        else if (Input.GetKey(KeyCode.S) || Input.GetKey(KeyCode.DownArrow))
        { 
            speedY = -verticalSpeed;
        }
        transform.Translate(speedX, speedY, 0);
        speedX = 0;
        speedY = 0;
        anim();
}
    void anim() {
       // Left = Obj.GetComponent<Animation>().Play ("");
    
        if (Input.GetKey(KeyCode.A) || Input.GetKey(KeyCode.LeftArrow))
        {
            Obj.GetComponent<Animation>().Play("Left");
        }
        else if (Input.GetKey(KeyCode.D) || Input.GetKey(KeyCode.RightArrow))
        {
        }
        if (Input.GetKey(KeyCode.W) || Input.GetKey(KeyCode.UpArrow))
        {
        }
        else if (Input.GetKey(KeyCode.S) || Input.GetKey(KeyCode.DownArrow))
        {
            Obj.GetComponent<Animation>().Play(nameanim_2);
        }

    }
}
