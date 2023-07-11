// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  public TalonFX frontLeftMotor;
  public TalonFX frontRightMotor;
  public TalonFX backLeftMotor;
  public TalonFX backRightMotor;

  public DriveSubsystem() {
    this.frontLeftMotor = new TalonFX(4);
    this.frontRightMotor = new TalonFX(2);
    this.backLeftMotor = new TalonFX(3);
    this.backRightMotor = new TalonFX(1);

    this.frontLeftMotor.configFactoryDefault();
    this.frontRightMotor.configFactoryDefault();
    this.backLeftMotor.configFactoryDefault();
    this.backRightMotor.configFactoryDefault();

    this.frontLeftMotor.setInverted(false);
    this.frontRightMotor.setInverted(true);
    this.backLeftMotor.setInverted(false);
    this.backRightMotor.setInverted(true);

    this.frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    this.frontRightMotor.setNeutralMode(NeutralMode.Brake);
    this.backLeftMotor.setNeutralMode(NeutralMode.Brake);
    this.backRightMotor.setNeutralMode(NeutralMode.Brake);

    this.frontLeftMotor.config_kP(0, .1);
    this.frontLeftMotor.config_kI(0, 0);
    this.frontLeftMotor.config_kD(0, 0);

    this.frontRightMotor.config_kP(0, .1);
    this.frontRightMotor.config_kI(0, 0);
    this.frontRightMotor.config_kP(0, 0);

    this.backLeftMotor.config_kP(0, .1);
    this.backLeftMotor.config_kI(0, 0);
    this.backLeftMotor.config_kD(0, 0);

    this.backRightMotor.config_kP(0, .1);
    this.backRightMotor.config_kI(0, 0);
    this.backRightMotor.config_kD(0, 0);
  }

  public void velocityControl (double speed){
    //the speed is in encoder ticks per second
    this.frontLeftMotor.set(ControlMode.Velocity, speed);
    this.frontRightMotor.set(ControlMode.Velocity, speed);
    this.backLeftMotor.set(ControlMode.Velocity, speed);
    this.backRightMotor.set(ControlMode.Velocity, speed);
  }

  public void positionControl (double encoderTicks) {
    this.frontLeftMotor.set(ControlMode.Position, encoderTicks);
    this.frontRightMotor.set(ControlMode.Position, encoderTicks);
    this.backLeftMotor.set(ControlMode.Position, encoderTicks);
    this.backRightMotor.set(ControlMode.Position, encoderTicks);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
