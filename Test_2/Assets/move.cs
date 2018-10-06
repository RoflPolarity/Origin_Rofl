using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class move : MonoBehaviour
{
    private Animator animat;
    public float horizantalSpeed, verticalSpeed;
    float speedX, speedY;
    void Start()
    {
        animat = GetComponent<Animator>();
    }

    void Update()
    {
        if (Input.GetKey(KeyCode.A) || Input.GetKey(KeyCode.LeftArrow))
        {
            speedX = -horizantalSpeed;
            animat.Play("Left");
            animat.Play("stay");
        }
        else if (Input.GetKey(KeyCode.D) || Input.GetKey(KeyCode.RightArrow))
        {
            speedX = horizantalSpeed;
            animat.Play("Right");
            animat.("stay");
        }
        if (Input.GetKey(KeyCode.W) || Input.GetKey(KeyCode.UpArrow))
        {
            speedY = verticalSpeed;
            animat.Play("ot_user");
            animat.Play("stay");
        }
        else if (Input.GetKey(KeyCode.S) || Input.GetKey(KeyCode.DownArrow))
        {
            speedY = -verticalSpeed;
            animat.Play("on_user");
            animat.Play("state");
        }
        transform.Translate(speedX, speedY, 0);
        speedX = 0;
        speedY = 0;
    }
}
    