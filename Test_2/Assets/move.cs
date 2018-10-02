using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class move : MonoBehaviour {
    public GameObject player;
    public int speed = 5;
    public int speedRotation = 3;
    // Use this for initialization
    void Start () {
        player = (GameObject)this.gameObject;
    }
	
	// Update is called once per frame
	void Update () {
        if (Input.GetKey(KeyCode.W) || Input.GetKey(KeyCode.UpArrow))
        {
           
        }
        if (Input.GetKey(KeyCode.S) || Input.GetKey(KeyCode.DownArrow))
        {
           
        }
        if (Input.GetKey(KeyCode.A) || Input.GetKey(KeyCode.LeftArrow))
        {
            player.transform.position += player.transform.forward * speed * Time.deltaTime;
        }
        if (Input.GetKey(KeyCode.D) || Input.GetKey(KeyCode.RightArrow))
        {
            player.transform.position -= player.transform.forward * speed * Time.deltaTime;
        }
    }
}
