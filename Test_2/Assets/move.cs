using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class move : MonoBehaviour
{
    private PolygonCollider2D coll, paths, element0;
    Vector2 points;
    private GameObject ManeChar;
    private Animator animat;
    public float horizantalSpeed, verticalSpeed;
    float speedX, speedY;
    private string lastNav = "onUser";
    void Start()

    {
        ManeChar = GameObject.Find("char");
        coll = ManeChar.GetComponent<PolygonCollider2D>();
        animat = GetComponent<Animator>();
    }

    void Update()
    {
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
    void anim()
    {
        if (Input.GetKey(KeyCode.D) || Input.GetKey(KeyCode.RightArrow))
        {
            animat.Play("Right");
            lastNav = "Right";
        }
        else if (lastNav.Equals("Right"))
        {
            animat.Play("Right_stay");
        }
        if (Input.GetKey(KeyCode.A) || Input.GetKey(KeyCode.LeftArrow))
        {
            animat.Play("Left");
            lastNav = "Left";
        }
        else if (lastNav.Equals("Left"))
        {
            animat.Play("Left_stay");
        }
        if (Input.GetKey(KeyCode.W) || Input.GetKey(KeyCode.UpArrow))
        {
            animat.Play("otUser");
            lastNav = "otUser";
        }
        else if (lastNav.Equals("otUser"))
        {
            animat.Play("otUser_stay");

        }
        if (Input.GetKey(KeyCode.S) || Input.GetKey(KeyCode.DownArrow))
        {
            animat.Play("onUser");
            lastNav = "onUser";
        }
        else if (lastNav.Equals("onUser"))
        {
            animat.Play("onUser_stay");
        }
    }
}