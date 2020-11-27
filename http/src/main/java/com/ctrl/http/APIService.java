package com.ctrl.http;


import com.ctrl.bean.Contact;
import com.ctrl.bean.Device;
import com.ctrl.bean.DeviceDetail;
import com.ctrl.bean.GateHistory;
import com.ctrl.bean.Login;
import com.ctrl.bean.Problem;
import com.ctrl.bean.ProblemCount;
import com.ctrl.bean.Site;
import com.ctrl.bean.SiteData;
import com.ctrl.bean.Sluice;
import com.ctrl.bean.TraceHistory;
import com.ctrl.bean.TraceProblem;
import com.ctrl.bean.TraceTask;
import com.ctrl.bean.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface APIService {

    /**
     * 用户登录
     *
     * @param params username password
     * @return Login
     */
    @FormUrlEncoded
    @POST("app/login/verify")
    Observable<RespModel<Login>> login(@FieldMap Map<String, String> params);

    /**
     * 用户信息同步
     *
     * @param params userId
     * @return User
     */
    @FormUrlEncoded
    @POST("app/user/ById")
    Observable<RespModel<User>> synUser(@FieldMap Map<String, String> params);

    /**
     * 获取水位管理所信息
     *
     * @param params deptId
     * @return List<Site>
     */
    @FormUrlEncoded
    @POST("app/StbprpWaterReal/list-dept")
    Observable<RespModel<List<Site>>> fetchWaterSite(@FieldMap Map<String, String> params);

    /**
     * 获取流量管理所信息
     *
     * @param params deptId
     * @return List<Site>
     */
    @FormUrlEncoded
    @POST("app/RiverFlowRealApp/list-dept")
    Observable<RespModel<List<Site>>> fetchFlowSite(@FieldMap Map<String, String> params);

    /**
     * 获取墒情管理所信息
     *
     * @param params deptId
     * @return List<Site>
     */
    @FormUrlEncoded
    @POST("app/moistureRealApp/list-dept")
    Observable<RespModel<List<Site>>> fetchMSite(@FieldMap Map<String, String> params);

    /**
     * 获取闸门管理所信息
     *
     * @param params deptId
     * @return List<Site>
     */
    @FormUrlEncoded
    @POST("app/CtrlGate/list-dept")
    Observable<RespModel<List<Site>>> fetchSluiceSite(@FieldMap Map<String, String> params);

    /**
     * 实时水位数据
     *
     * @param params deptId
     * @return List<Site>
     */
    @FormUrlEncoded
    @POST("app/StbprpWaterReal/list-water")
    Observable<RespModel<List<SiteData>>> fetchWaterLevelByDept(@FieldMap Map<String, String> params);

    /**
     * 实时流量数据
     *
     * @param params deptId
     * @return List<Site>
     */
    @FormUrlEncoded
    @POST("app/RiverFlowRealApp/list-liuliang")
    Observable<RespModel<List<SiteData>>> fetchFlowByDept(@FieldMap Map<String, String> params);

    /**
     * 实时墒情数据
     *
     * @param params deptId
     * @return List<Site>
     */
    @FormUrlEncoded
    @POST("app/moistureRealApp/list-soil")
    Observable<RespModel<List<SiteData>>> fetchMByDept(@FieldMap Map<String, String> params);

    /**
     * 实时闸门数据
     *
     * @param params manageId
     * @return List<Site>
     */
    @FormUrlEncoded
    @POST("app/CtrlGate/list-station")
    Observable<RespModel<List<Sluice>>> fetchSluiceByDept(@FieldMap Map<String, String> params);

    /**
     * 实时闸孔数据
     *
     * @param params id
     * @return List<Site>
     */
    @FormUrlEncoded
    @POST("app/CtrlGate/list-gate")
    Observable<RespModel<List<Sluice>>> fetchSluiceHoleById(@FieldMap Map<String, String> params);

    /**
     * 实时水位数据（已废弃）
     *
     * @param params deptId
     * @return List<Site>
     */
    @Deprecated
    @FormUrlEncoded
    @POST("app/StbprpWaterReal/listDataWater")
    Observable<RespModel<List<Site>>> fetchWaterLevel(@FieldMap Map<String, String> params);

    /**
     * 实时流量数据（已废弃）
     *
     * @param params deptId
     * @return List<Site>
     */
    @Deprecated
    @FormUrlEncoded
    @POST("app/RiverFlowRealApp/listDataLiuLing")
    Observable<RespModel<List<Site>>> fetchFlow(@FieldMap Map<String, String> params);

    /**
     * 实时闸门数据（已废弃）
     *
     * @param params deptId
     * @return List<Site>
     */
    @Deprecated
    @FormUrlEncoded
    @POST("app/CtrlGate/listDataGate")
    Observable<RespModel<List<Sluice>>> fetchSluice(@FieldMap Map<String, String> params);

    /**
     * 实时墒情数据（已废弃）
     *
     * @param params deptId
     * @return List<Site>
     */
    @Deprecated
    @FormUrlEncoded
    @POST("app/moistureRealApp/listDataSoil")
    Observable<RespModel<List<Site>>> fetchMo(@FieldMap Map<String, String> params);

    /**
     * 获取设备
     *
     * @param params deptId,type
     * @return List<Device>
     */
    @FormUrlEncoded
    @POST("app/CtrlEquipmentManageApp/list")
    Observable<RespModel<List<Device>>> fetchDevice(@FieldMap Map<String, String> params);

    /**
     * 获取设备详细信息
     *
     * @param params deptId,type
     * @return List<Device>
     */
    @FormUrlEncoded
    @POST("app/CtrlEquipmentManageApp/listByRTU")
    Observable<RespModel<DeviceDetail>> fetchDeviceDetail(@FieldMap Map<String, String> params);

    /**
     * 问题上报
     *
     * @param params 图片，表单
     * @return
     */
    @Multipart
    @POST("app/DangerReportView/add")
    Observable<RespModel<String>> postProblems(@Part List<MultipartBody.Part> list,
                                               @PartMap Map<String, RequestBody> params);

    /**
     * 获取问题上报信息汇总
     *
     * @param params deptId
     * @return List<ProblemCount>
     */
    @FormUrlEncoded
    @POST("app/DangerReportView/list")
    Observable<RespModel<ProblemCount>> fetchProblemCount(@FieldMap Map<String, String> params);

    /**
     * 获取处理问题列表
     *
     * @param params deptId,pageNum,pageSize,settleStatus
     * @return List<Problem>
     */
    @FormUrlEncoded
    @POST("app/DangerReportView/ListStatus")
    Observable<RespModel<List<Problem>>> fetchProblem(@FieldMap Map<String, String> params);

    /**
     * 未处理问题查看
     *
     * @param params id
     * @return List<Problem>
     */
    @FormUrlEncoded
    @POST("app/DangerReportView/listNoSettle")
    Observable<RespModel<Problem>> fetchProblemItem(@FieldMap Map<String, String> params);

    /**
     * 已处理问题查看
     *
     * @param params id
     * @return List<Problem>
     */
    @FormUrlEncoded
    @POST("app/DangerReportView/listSettle")
    Observable<RespModel<Problem>> fetchHandledProblemItem(@FieldMap Map<String, String> params);

    /**
     * 处理上报问题
     *
     * @param params id,settleBy,settleStatus,settleContent,files
     * @return List<String>
     */
    @Multipart
    @POST("/app/DangerReportView/update")
    Observable<RespModel<String>> respondProblems(@Part List<MultipartBody.Part> list,
                                                  @PartMap Map<String, RequestBody> params);

    /**
     * 值班上报
     *
     * @param params id
     * @return List<Problem>
     */
    @FormUrlEncoded
    @POST("app/InspectionScheduling/add")
    Observable<RespModel<String>> postDutyReport(@FieldMap Map<String, String> params);

    /**
     * 巡检开始
     *
     * @param params createBy,title,status(始终为1)
     * @return String id当前巡检id
     */
    @FormUrlEncoded
    @POST("app/ctrlXunjianJobApp/start")
    Observable<RespModel<TraceTask>> startTrace(@FieldMap Map<String, String> params);

    /**
     * 上报轨迹
     *
     * @param params points,jobId,userId
     * @return null
     */
    @FormUrlEncoded
    @POST("app/PatrolRreportTrack/add")
    Observable<RespModel<TraceTask>> uploadTrace(@FieldMap Map<String, String> params);

    /**
     * 巡检结束
     *
     * @param params jobId,roadLong
     * @return null
     */
    @FormUrlEncoded
    @POST("app/ctrlXunjianJobApp/end")
    Observable<RespModel<TraceTask>> endTrace(@FieldMap Map<String, String> params);

    /**
     * 巡检时问题上报数据
     *
     * @param params jobId
     * @return null
     */
    @Multipart
    @POST("app/InspectionManager/add")
    Observable<RespModel<TraceProblem>> postTraceProblems(@Part List<MultipartBody.Part> list,
                                                            @PartMap Map<String, RequestBody> params);

    /**
     * 巡检记录中上报的所有数据
     *
     * @param params jobId
     * @return null
     */
    @FormUrlEncoded
    @POST("app/InspectionManager/list")
    Observable<RespModel<TraceProblem>> fetchTraceProblems(@FieldMap Map<String, String> params);

    /**
     * 个人巡检数据-头部
     *
     * @param params createBy
     * @return TraceTask
     */
    @FormUrlEncoded
    @POST("app/ctrlXunjianJobApp/list-head")
    Observable<RespModel<TraceTask>> traceInfoHead(@FieldMap Map<String, String> params);

    /**
     * 个人巡检数据-一级列表
     *
     * @param params createBy,pageNum,pageSize
     * @return TraceTask
     */
    @FormUrlEncoded
    @POST("app/ctrlXunjianJobApp/list-body")
    Observable<RespModel<List<TraceTask>>> traceInfoList(@FieldMap Map<String, String> params);

    /**
     * 个人巡检数据-二级列表
     *
     * @param params createBy,pageNum,pageSize,byTime
     * @return TraceTask
     */
    @FormUrlEncoded
    @POST("app/ctrlXunjianJobApp/list-unfold")
    Observable<RespModel<List<TraceTask>>> traceInfoDetailList(@FieldMap Map<String, String> params);

    /**
     * 单条巡检记录数据
     *
     * @param params id
     * @return TraceHistory
     */
    @FormUrlEncoded
    @POST("app/ctrlXunjianJobApp/ByJobId")
    Observable<RespModel<TraceHistory>> fetchTraceHistory(@FieldMap Map<String, String> params);

    /**
     * 单条巡检记录数据
     *
     * @param params jobId
     * @return TraceHistory
     */
    @FormUrlEncoded
    @POST("app/ctrlXunjianJobApp/ListDanger")
    Observable<RespModel<List<Problem>>> fetchTraceHistoryProblems(@FieldMap Map<String, String> params);


    /**
     * 通讯录
     *
     * @param params <?></>
     * @return Contact
     */
    @FormUrlEncoded
    @POST("app/AddressBookManager/list")
    Observable<RespModel<List<Contact>>> fetchContact(@FieldMap Map<String, String> params);

    /**
     * 闸控记录
     *
     * @param params <?></>
     * @return History
     */
    @FormUrlEncoded
    @POST("app/CtrlGateAlter/appList")
    Observable<RespModel<List<GateHistory>>> fetchGateHistory(@FieldMap Map<String, String> params);
}
