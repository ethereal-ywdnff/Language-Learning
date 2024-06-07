#!/usr/bin/env python

import rospy
from sensor_msgs.msg import LaserScan
from geometry_msgs.msg import Twist

class ObstacleAvoidance:
    def __init__(self):
        rospy.init_node('obstacle_avoidance')
        rospy.Subscriber('/scan', LaserScan, self.scan_callback)
        self.pub = rospy.Publisher('/cmd_vel', Twist, queue_size=1)
        self.twist = Twist()

    def scan_callback(self, msg):
        # Get the distance to the closest obstacle on the right side
        obstacle_distance = msg.ranges[0]

        # If the obstacle is within 0.4 meters, turn 90 degrees
        if obstacle_distance <= 0.4:
            self.twist.linear.x = 0.0
            self.twist.angular.z = 1.0  # Turn right
        else:
            self.twist.linear.x = 0.5  # Move forward
            self.twist.angular.z = 0.0

        self.pub.publish(self.twist)

    def run(self):
        rospy.spin()

if __name__ == '__main__':
    try:
        avoidance = ObstacleAvoidance()
        avoidance.run()
    except rospy.ROSInterruptException:
        pass

